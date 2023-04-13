import {useState} from "react";

function ValueChanger() {
    const [value, setValue] = useState('Default');

    function eventChanger(event) {
        setValue(event.target.value)
    }

    return (
        <div>
            <h1>{value}</h1>
            <input type={"text"} value={value} onChange={(event) => {
                eventChanger(event)
            }}/>
        </div>
    )


}
export default ValueChanger