import React, { Component } from "react";
import MyShelf from "./MyShelf"

class App extends Component {

  state =
  {
    data: []
  }

  componentDidMount(){
    fetch('http://localhost:8080/api/myshelf/all')
    .then(response => response.json())
    .then(data =>{
      console.log(data);
      this.setState({data})
    });
  }

  render(){
  return (
    <div>
      {this.state.data.map(myshelf => <MyShelf info={myshelf}/>)}
    </div>
  );
}

}



export default App;
