# OO Design and GSON
## In today lecture we got introduced  to GSON and how we can deal with it, we start  reading from JSON file and what we did is the following :
### A) `App.java:`
* #### `1. getRandomBook() :`
    * ##### In this method we start using Gson dependencies by creating an object instance to use it to read the Json file.
    * ##### The output of our file is an array of object, and we need to get one object each time when we run.
    * ##### We used the random method to generate random number and provide as a index for the array to get one object.
* #### `2. getSpecificBook() :`
    * ##### This method is the same as the book method, but we're passing a number, and the file path for testing purpose
### B) `recentQuotes.java:`
* #### In this class we are declaring the primitive type that we will get from the JSON file and converting them to String.
### C) To use this application you need to :
* #### After clone the repo make sure that you have this dependencies in the *build.gradle*.
> https://mvnrepository.com/artifact/com.google.code.gson/gson
implementation group: 'com.google.code.gson', name: 'gson', version: '2.8.6'
* #### Add your absolute path in the *getRandomBook* method to make run and get random book .
* #### You can the  application in terminal using this command `./gradlew run `
* #### And for running the test you need this command `./gradlew test`

# *Lab 9* Web requests

## For today lab we start reading data from API using buffer reader and input stream to deal correctly with it.
### `apiQuotes`
#### we create this class to get data from api and save it in the json file.