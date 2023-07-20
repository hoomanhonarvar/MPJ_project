import React,{useState} from "react";
import { TextField,Typography ,Button, backdropClasses} from "@mui/material";
import Image from './1.png'
import './Signup.css'

  import { useHistory } from "react-router-dom/cjs/react-router-dom.min";
// import React from "react";
function Signup(){
    let hisory=useHistory();
    const [message,setMessage]=useState("");
    const [posts, setPosts] = useState([]);
    const [username ,setUsername]=useState("");
    const [password,setPassword]=useState("");
    const [url,setUrl]=useState("");
const handleSubmit= async(event)=>{
    event.preventDefault(); 
       
        const response =await fetch ('http://127.0.0.1:8080/users/signup',{
            method: 'POST',
            headers:{
                'Content-Type':'application/json'
            },
            body:JSON.stringify({
                username: username,
                password:password
            })
            

        })
        .then(response => {
    let resp = response;
    if (response.status===201){
         setMessage("User created succesfully");
         if(response.status===201){
           setMessage("user created succesfully!")
           hisory.push("/chat");
           hisory.go(0);
        }
    }
     else{
    setMessage("Some error occured");
  }
  })
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
                    <TextField type="email" onChange={(e)=>setUsername(e.target.value)} />
                </div>
                <div className="Frame4">
                    <Typography>
                        PASSWORD:
                    </Typography>
                </div>
                <div className="Frame5">
                     <TextField type="password" onChange={(e)=>setPassword(e.target.value)} />

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
                <div className={"p-10 flex w-full gap-4 flex-col "}>
                  {message}
                </div> 
                
                
                      
            </div> 
           
        </div>
    )
}

export default Signup;