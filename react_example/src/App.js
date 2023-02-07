import React, {useState} from 'react';
import ClassCounter from "./Components/ClassCounter";

function App() {
    const [value, setValue] = useState('Some text');



    function changeValue(event) {
        setValue(event.target.value);
    }

    return (
        <div className="App">
       <ClassCounter/>

        </div>
    );
}

export default App;
