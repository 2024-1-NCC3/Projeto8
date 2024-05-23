const mysql = require("mysql2");
const express = require("express")
const app = express()

app.use(express.json())

app.listen(3306, () => {
    console.log("Listening on port 3306")
})

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

    app.post("/registrarUser", (req, res) => {
      const novoUser = {
        nome: req.body.nome,
        email: req.body.email,
        senha: req.body.senha
      }

      conn.query('SELECT email FROM login WHERE email = ?', [novoUser.email],
        function (err, results, fields) {
            if(err){
              throw err;
            }
            else if (result == null){
              conn.query('INSERT INTO login (nome, email, senha) VALUES (?, ?, ?)', [novoUser.nome, novoUser.email, novoUser.senha],
              function (err, results, fields) {
                if (err) throw err;
                else console.log('Foi inserido ' + results.affectedRows + ' linha(s)');
              })

              conn.end(function (err) {
                if (err) throw err;
                else  console.log('Done.')
              });
            }
            else{
              console.log("Usuario já inserido")
            }

        })

    })
  }
});

