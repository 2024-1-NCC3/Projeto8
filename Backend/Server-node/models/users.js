const mysql = require("mysql2");
const validator = require("validator")
const bcrypt = require("bcryptjs")
const jwt = require("jsonwebtoken")

const userSchema = mysql.Schema({
    name:{
        type: String,
        required: true,
        trim: true
    },
    email:{
        type: String,
        required: true,
        trim: true,
        unique: true,
        lowercase: true,
        validate: value=> {
            if(!validator.isEmail(value)){
                throw new Error({error: "Endereço de email inválido"})
            }
        }
    },
    password:{
        type: String,
        required: true,
        trim: true,
        minLenght:5,
    },
    tokens:[{
        token: {
            type: String,
            required: true
        }
    }]
})

userSchema.pre("save", async function (next){
    // Password hash
    const user = this
    if(user.isModified("password")){
        user.password = await bcrypt.hash(user.password, 8)
    }
})

userSchema.static,findByCredentials = async (email, password) => {
    const user = await User.findOne({email})
    if(!user){
        throw new Error({error: "Email ou senha incorretos"})
    }
    const isPasswordMatch = await bcrypt.compare(password, user.password)
    if(!isPasswordMatch){
        throw new Error({error: "Email ou senha incorretos"})
    }
}

const User = mysql.model("User", userSchema)

module.exports = User