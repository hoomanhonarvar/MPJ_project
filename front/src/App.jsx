import Login from "./components/login/Login";
import P2P from "./components/P2P/P2P"
import Signup from "./components/Signup/Signup";
import {
  BrowserRouter ,
  Route,
  Switch,
} from 'react-router-dom';
import {useNavigate} from 'react-router-dom';
// import './App.css'
function App() {
  return (
      
    <BrowserRouter>
     <Switch>



      
      <Route exact path='/'>
        <Login />
      </Route>
      <Route exact path='/chat'>
        <P2P />
      </Route>
      <Route exact path ='/Signup'>
        <Signup />
      </Route>
     
     
     
     
     
     
     </Switch>
     
     </BrowserRouter>
     
     
     

  );
}

export default App;
