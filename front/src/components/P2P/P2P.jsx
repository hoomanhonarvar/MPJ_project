
import './P2P.css'
import {TextField} from "@mui/material";
import {AiOutlineUser} from "react-icons/ai"
const P2P=()=>{
    return(
        <div>
        <div className="Desktop-1">
                
            <div className="Frame600">
                <div className="Frame700">
                {/* <input placeholder='maviiii' /> */}
                <TextField variant='outlined' fullWidth label="Search" placeholder='Search' className={"p-10 "}/> 



                </div>
                <div className="Frame800">
                    <div className='Frame2000'>
                        <button>
                        <div className='Frame2300'>
                        <AiOutlineUser />
                            hooman
                        </div>
                        </button>

                    </div>
                    <div className='Frame2000'>
                    <button>
                        <div className='Frame2300'>
                        <AiOutlineUser />
                            hooman
                        </div>
                        </button>

                    </div>
                    <div className='Frame2000'>
                    <button>
                        <div className='Frame2300'>
                        <AiOutlineUser />
                            hooman
                        </div>
                        </button>

                    </div>
                    <div className='Frame2000'>
                    <button>
                        <div className='Frame2300'>
                        <AiOutlineUser />
                            hooman
                        </div>
                        </button>

                    </div>
                    <div className='Frame2000'>
                    <button>
                        <div className='Frame2300'>
                        <AiOutlineUser />
                            hooman
                        </div>
                        </button>

                    </div>

                </div>
            </div>
            <div className="Frame100">
                <div className="Frame200">
                    <div className="Frame8800">

                        <AiOutlineUser />
                        hooman
                    </div>
                

                </div>
                <div className="Frame300">
                    <div className="Frame400">

                    </div>
                    <div className="Frame500">
                        <div className="Frame900">
                            <input className="Input00" placeholder="type..." color="white"/>
                            <button className="Button00">
                                Send
                            </button>
                             
                        </div>
                    </div>
                </div>

            </div>
            
        </div>
        </div>

    );


}


export default P2P;
