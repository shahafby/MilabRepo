"use strict";
const express = require('express');
const MongoClient = require('mongodb').MongoClient;
const MONGO_URL = "mongodb://root:root@ds117178.mlab.com:17178/songs-db";
const app = express();
const bodyParser = require('body-parser');
const PORT = process.env.PORT || 3000;

let server = express();
server.use(bodyParser.json());


server.put('/addSong', (req, res) => {
	addSongToDB(req, res);
});

server.get('/getSong/:key/:value', (req, res) => {
	let key = req.params.key;
	let value = req.params.value;
	if(!key || !value){
		res.status(400).send('Did not get any searching parameters');
		return;
	}
	getSongFromDB(req, res, key, value);
});

server.post('/update/:songName', (req, res) => {
	let songName = req.params.songName
	updateSongInDB(req, res, songName);
});

server.delete('/delete/:songName', (req, res) => {
	let songName = req.params.songName
	deleteSongFromDB(req, res, songName);
})

let addSongToDB = (req, res) => {
	let data = req.body;
	if(!data){
		res.status(400).send('Did not get any data');
		return;
	}
	MongoClient.connect(MONGO_URL, (err, db) => {
		if(err){
			console.log('Could not connect to Database');
			res.status(503).send('could not connect to Database');
			return;
		}
		let database = db.db('songs-db');
		let collection = database.collection('songsCollection');
		collection.insertOne(data, (err, cb) => {
			if(err){
				console.error(err);
				console.log('Could not create data');
				res.status(503).send('write failed');
				return;
			}
			console.log(`One record was enterd successfully`);
			res.status(200).send('data created');
		});
		db.close();
	});
}

let getSongFromDB = (req, res, key ,value) => {

	MongoClient.connect(MONGO_URL, (err, db) => {
		if(err){
			res.status(503).send('could not connect to database');
			return;
		}
		let database = db.db('songs-db');
		let collection = database.collection('songsCollection');
		collection.find({[key] : value}).toArray((err, result) => {
			if(err){
				console.error(err);
				console.log('err while searching in DB');
				res.status(503).send('find failed');
				return;
			}
			console.log(`Found ${result.length} records that matched the query`);
			if(!result[0]){
				res.status(200).send("Did not find any data")
			}
			res.status(200).send(JSON.stringify(result[0]));
		});
		db.close();
	});
}

let updateSongInDB = (req, res, songName) => {
	let newData = req.body;
	if(!newData){
		res.status(400).send('Did not get input');
		return;
	}
	MongoClient.connect(MONGO_URL, (err, db) => {
		if(err){
			console.log('Could not connect to Database');
			res.status(503).send('could not connect to db');
			return;
		}
		let database = db.db('songs-db');
		let collection = database.collection('songsCollection');
		
		collection.updateOne( { "name" : songName },  { $set: newData },
			(err, db) => {
				if(err){
					console.error(err);
					console.log('Could not update data');
					res.status(503).send('update failed');
					return;
				}
				console.log(`Successfully updated ${songName}`);
				res.status(200).send(`Successfully updated ${songName}`);
			}
		);
		db.close();
	});
}

let deleteSongFromDB = (req, res, songName) => {
	
	MongoClient.connect(MONGO_URL, (err, db) => {
		if(err){
			console.log('Could not connect to Database');
			res.status(503).send('could not connect to db');
			return;
		}
		let database = db.db('songs-db');
		let collection = database.collection('songsCollection');
		collection.deleteOne(
			{ "name" : songName },
			(err, cb) => {
				if(err){
					console.error(err)
					console.log('Could not delete data');
					res.status(503).send('delete failed');
					return;
				}
				res.status(200).send('data deleted');
			});
		db.close();
	});
}

server.listen(PORT, () => console.log(`listening in port ${PORT}`));
