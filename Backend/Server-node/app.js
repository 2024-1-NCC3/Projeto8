const express = require("express")
const userRouter = require("./routers/users")
const port = process.env.PORT
require("./db/db-connection")

const app = express()

app.use(express.urlencoded({extended: true}))
app.use(express.json())
app.use(userRouter)

app.listen(port, ()=> {
    console.log(`Server está no port ${port}`)
})