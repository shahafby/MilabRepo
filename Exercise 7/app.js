const express = require('express');
const fs = require('fs');

let app = express();

app.get('/getTime', (req, res) => {
    let name = req.query.name || 0;
    res.send(new Date);
});

app.get('/getFile',(req, res) => {
    let name = req.body.filename || "<test.txt>";
    fs.readFile(filename,(err, content) => {
        if (err) {
            console.error(err);
            return;
        }
        res.send(content);
    });
}

app.listen(3000, () => {
    console.log('Listening on port 3000!');
});