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