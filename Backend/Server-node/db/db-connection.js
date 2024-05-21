const mysql = require("mysql2");

var config = {
  host: "doesanguedb.mysql.database.azure.com",
  user: "grupodoesangue",
  password: "doesangue1023!",
  database: "users",
  port: 3306,
  connectTimeout: 30000,
};

const conn = new mysql.createConnection(config);

conn.connect(function (err) {
  if (err) {
    console.log("Erro na conexão");
    throw err;
  } else {
    console.log("Conexão estabelecida.");
  }
});