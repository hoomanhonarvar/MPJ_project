import React,{useState} from "react";
import { TextField,Typography ,Button, backdropClasses} from "@mui/material";
import Image from './1.png'
import './Signup.css'
import {Link} from 'react-router-dom'
// import React from "react";
function Signup(){
    const [message,setMessage]=useState("");

    // const [inputs, setInputs] = useState({
    //     username:"",
    //     password:""
    // });
    const [posts, setPosts] = useState([]);
    const [username ,setUsername]=useState("");
    const [password,setPassword]=useState("");
const handleSubmit= async(event)=>{
    event.preventDefault(); 
        //  this.handleSubmit=this.handleSubmit.bind(this);
        // const response = await fetch("http://localhost:8080/users/signup",
        // {
        //     method: 'POST',
        //     headers:{'Content-Type':'application/json'},
        //     body:JSON.stringfy({
        //         "username":username,
        //         "password":password
        //     })
        // });
        // const result =await response.json()
        // console.log(result)
        // if(result.status===200){
            
        //     setMessage("user created succesfully");
        //     console.log(message.target.value);
        // }
        // else{
        //     setMessage("some erroe occured");
        //     console.log(message.target.value);
        // }
        console.log(username)
        const response =await fetch ('http://127.0.0.1:8080/users/signup',{
            method: 'POST',
            headers:{
                'Content-Type':'application/json'
                //  'Access-Control-Allow-Origin': '*',
            },
            body:JSON.stringify({
                username: username,
                password:password
            })
            

        })
        


        // .then((response)=>response.json())
        // .then((post)=>{
        //     setPosts((posts)=>[post,...posts]);
        //     setUsername(username);
        //     setPassword(password);
        // })
        // .catch((err)=>{  
        //     console.log(err.message);
        // })
        // .then((response) => response.json());
        console.log(password)

  console.log(response)
  if (response.json().status===200){
    setMessage("User created succesfully");
    // setComment(result.JSON)
  }
  else{
    setMessage("Some error occured");
  }
  console.log(message)
}
    
    return(

        <div className="maincontainer">
            <div className="Frame2">
                <div className="Frame6">
                    <img src={Image} alt="logo" />
                </div>
                <form className="signup" onSubmit={handleSubmit}>
                <div className="Frame7">
                    <Typography variant="">
                        USERNAME:
                    </Typography>
                </div>
                <div className="Frame3">
                    {/* <TextField variant="outlined" label="USERNAME" className="field"  onChange={(e)=>setUsername(e.target.value)}> 

                    </TextField> */}
                    <input type="email" onChange={(e)=>setUsername(e.target.value)} />
                </div>
                <div className="Frame4">
                    <Typography>
                        PASSWORD:
                    </Typography>
                </div>
                <div className="Frame5">
                    {/* <TextField variant="outlined" label="PASSWORD" type="password" className="field" onChange={(e)=>setPassword(e.target.value)}>

                    </TextField> */}
                     <input type="password" onChange={(e)=>setPassword(e.target.value)} />

                </div> 
                <div>
                <br></br><br></br>
                </div>
                <div className="Frame1">
                    <button className="button00" type="submit" >
                        Submit
                    </button>  
                 
                </div> 
                </form> 
                <div className={"p-10 flex w-full gap-4 flex-col border 10xl"}>
                  {message}
                  {password}
                  {username}
                </div> 
                
                      
            </div> 
        </div>
    )
}

export default Signup;