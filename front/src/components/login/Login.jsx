import React,{useState} from "react";
import { TextField,Typography ,Button, backdropClasses} from "@mui/material";
import Image from './1.png'
import './login.css'
import {Link} from 'react-router-dom'
import { useHistory } from "react-router-dom/cjs/react-router-dom.min";


function Login(){
    const [inputs, setInputs] = useState({
        username:"",
        pass:""
    });
    let hisory=useHistory();
    const [message,setMessage]=useState("");
    const [username ,setUsername]=useState("");
    const [password,setPassword]=useState("");
    const history=useHistory();
    const handleSubmit= async(event)=>{
        event.preventDefault(); 
           
            const response =await fetch ('http://127.0.0.1:8080/users/signin',{
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
        if (response.status===200){
             setMessage("User created succesfully");
               hisory.push("/chat");
               hisory.go(0);
            
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
                <form className="signin" onSubmit={handleSubmit}>

                <div className="Frame7">
                    <Typography variant="">
                        USERNAME:
                    </Typography>
                </div>
                <div className="Frame3">
                    <TextField variant="outlined" label="USERNAME" className="field" onChange={(e)=>setUsername(e.target.value)} /> 

                </div>
                <div className="Frame4">
                    <Typography>
                        PASSWORD:
                    </Typography>
                </div>
                <div className="Frame5">
                    <TextField variant="outlined" label="PASSWORD" type="password" className="field" onChange={(e)=>setPassword(e.target.value)} />

                </div> 
                <div>
                <br></br><br></br>
                </div>
                <div className="Frame1">
                    <button className="button00" type="submit">
                        Submit
                    </button>   
                </div>   
                <div>
                <br></br><br></br>
                </div>
                <div>
                    <Typography>
                        Don't have an account?
                    </Typography>
                    </div>
                    <div className="Frame1">
                        <Link to="/signup" >
                        <button className="button00" type="button"onClick={() => {window.location.href="/signup"}} >
                             Sign up
                        </button>
                        </Link>

                   
                </div> 
                </form> 
                <div className={"p-10 flex w-full gap-4 flex-col "}>
                  {message}
                </div>       
            </div> 
        </div>
    )
}

export default Login;