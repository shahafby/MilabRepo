# EXERCISE11
shahaf ben yakir

Retreive song from DB
GET     https://protected-peak-55663.herokuapp.com/getSong/Key/:Value
    Key: Name / Artist / Album or any other field name that was entered
    Value: the value of the KEY that was specified


Enter song
PUT     https://protected-peak-55663.herokuapp.com/addSong

    Body example:
                            {
                                "name": "Hallelujah",
                                "artist": "Jeff Bucklly",
                                "album": "Grace",
                                "janner": "Soul"
                            }


Update a song
POST    https://protected-peak-55663.herokuapp.com/update/:SongName
SongName: The name of the song to be deleted

    Body example:
                            {
                                "artist": "maximlian"
                            }
                            

Delete a song
DELETE      https://protected-peak-55663.herokuapp.com/delete/:SongName
    SongName: The name of the song to be deleted
    
