=============
 - > git clone <path>
- if maven is not installed on your machine, install it ...
- > mvn clean install jetty:run
- Jetty runs on port 7070, configured in the pom.xml-file
- run the below examples in browser.

=============

- Original : 		http://images.morphbank.net/?id=735451&imgType=jpg

- Wrapped in RESTful: 	/media/stream/{morphbankID}

- Wrapped Example : 	http://localhost:7070/media/stream/735451



- Original :		http://images.morphbank.net/Image/viewFrame.php?id=735451&width=800&height=600

- Wrapped in RESTful: 	/media/stream/{morphbankID}/{width}/{height}

- Wrapped Example : 	http://localhost:7070/media/stream/735451/800/600


- Original : 		http://images.morphbank.net/imageSizes.php?id=735451&imgType=jpg

- Wrapped in RESTful: 	/media/metadata/{morphbankID}/{mime}

- Wrapped Example : 	http://localhost:7070/media/metadata/735451/jpg


- Original : 		http://www.morphbank.net/checkImageAuthorization.php?728053

- Wrapped in RESTful: 	/media/authorization/{morphbankID}

- Wrapped Example : 	http://localhost:7070/media/authorization/735451

=============
Not included

- POST 
- PUT
- DELETE


