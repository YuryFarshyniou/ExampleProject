import React from 'react';
import './styles/App.css'
function App() {

    return (
        <div className="App">
            <div className={"post"}>
                <div className={"post_content"}>
                    <strong>1. JavaScript</strong>
                    <div>
                        Javascript - it's a programmer language.
                    </div>
                </div>
                <div className={"post__btns"}>
                    <button>Delete</button>
                </div>
            </div>
        </div>
    );
}

export default App;
