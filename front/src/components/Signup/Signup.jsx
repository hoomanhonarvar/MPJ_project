import React,{useState} from "react";
import { TextField,Typography ,Button, backdropClasses} from "@mui/material";
import Image from './1.png'
import './Signup.css'
const Signup=()=>{
    const [inputs, setInputs] = useState({
        username:"",
        pass:""
    });
    return(

        <div className="maincontainer">
            <div className="Frame2">
                <div className="Frame6">
                    <img src={Image} alt="logo" />
                </div>
                <div className="Frame7">
                    <Typography variant="">
                        USERNAME:
                    </Typography>
                </div>
                <div className="Frame3">
                    <TextField variant="outlined" label="USERNAME" className="field" > 

                    </TextField>
                </div>
                <div className="Frame4">
                    <Typography>
                        PASSWORD:
                    </Typography>
                </div>
                <div className="Frame5">
                    <TextField variant="outlined" label="PASSWORD" type="password" className="field">

                    </TextField>
                </div> 
                <div>
                <br></br><br></br>
                </div>
                <div className="Frame1">
                    <button className="button00" type="submit">
                        Submit
                    </button>   
                </div>   
                
                      
            </div> 
        </div>
    )
}

export default Signup;