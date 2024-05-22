const express = require("express")
const User = require("../models/users")
const router = express.Router()

router.get("/", async (req, res)=>{
    res.status(200).send("welcome")
})

router.post("/criarUser", async (req, res)=>{
    try{
        const user = new User(req.body)
        await user.save()
        res.status(201).send({user})
    } catch(error){
        res.status(400).send({error})
    }
})

router.post("/loginUser", async (req, res)=>{
    try {
        const {email, password} = req.body
        const user = await User.findByCredentials(email, password)
        if(!user){
            return res.status(401).send({error: "Email ou senha incorretos"})
        }
        res.status(200).send({user})
    } catch(error){
        res.status(400).send({error})
    }
})

module.exports = router