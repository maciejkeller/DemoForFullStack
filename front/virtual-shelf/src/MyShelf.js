import React, { Component } from "react";

class MyShelf extends Component {

    render() {
        return (
            <div>
                <p>--------------------------</p>
                <p>{this.props.info.id}</p>
                <p>{this.props.info.title}</p>
                <p>{this.props.info.author}</p>
                <p>{this.props.info.type}</p>
            </div>
        );
    }

}

export default MyShelf;