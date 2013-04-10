Rahul Mohandas
Project 3
This code can be compiled using ant
    When in the directory that contains build.xml you type ant and it should auto complie
    A jar file of the project has been included you can run the project with java -jar proj3.jar

Database Schema:
    FACULTY(fid, name, username, password)
    STUDENT(sid, name, username, password)
    EVALUATION(eid, cid, type, weight, deadline, sid, grade)
    ENROLLED(cid, sid);
    CLASS(cid, name, semester, year, meets_at, room, fid)

All usernames and passwords for faculty and students are located in the Input/Faculty.data and Input/Students.data
    the second to last field is the username and the last field is the password
