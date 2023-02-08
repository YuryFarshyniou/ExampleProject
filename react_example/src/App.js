import React, {useRef, useState} from 'react';
import './styles/App.css'
import PostList from "./Components/PostList";
import MyButton from "./Components/UI/button/MyButton";
import MyInput from "./Components/UI/input/MyInput";

function App() {
    const [posts, setPosts] = useState([
        {id: 55, title: "JavaScript", body: "JAvascript has a dick"},
        {id: 76, title: "Java", body: "Cool language"},
        {id: 999, title: "Python", body: "Fucking snake"}
    ])
    const [title, setTitle] = useState("");
    const bodyInputRef = useRef();

    const addNewPost = (e) => {
        e.preventDefault();
        console.log(bodyInputRef.current.value)
    }
    return (
        <div className="App">
            <form>
                <MyInput value={title}
                         onChange={e => setTitle(e.target.value)}
                         type="text"
                         placeholder="Post name"/>
                <input ref={bodyInputRef} type="text"/>
                {/*<MyInput*/}
                {/*    ref={bodyInputRef}*/}
                {/*    type="text"*/}
                {/*    placeholder="Post description"/>*/}
                <MyButton onClick={addNewPost}>Sometitle</MyButton>
            </form>
            <PostList posts={posts} title="Posts about JS"/>

        </div>
    );
}

export default App;
