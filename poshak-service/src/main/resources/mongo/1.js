use
admin;

db.createUser({user: "test", pwd: "test", roles: [{role: "userAdmin", db: "test"}]});

use
test;

db.user.insert({"name": "shourabh"});
db.user.insert({"name": "ayush"});
db.user.insert({"name": "himanshu"});
db.user.insert({"name": "mike"});

db.user.find();



db.user.insert({"email_id": "ayush@gmail.com", "password":"apple", "status":0});
db.user.insert({"email_id": "sourabh@gmail.com", "password":"sourabh", "status":0});
db.user.insert({"email_id": "himanshu@gmail.com", "password":"himanshu", "status":0});
