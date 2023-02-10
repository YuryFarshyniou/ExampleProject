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
    const [post, setPost] = useState({title: '', body: ''})

    const addNewPost = (e) => {
        e.preventDefault();
        setPosts([...posts,...post]);
        setPost({title: '', body: ''})
    }

    return (
        <div className="App">
            <form>
                <MyInput value={post.title}
                         onChange={e => setPost({...post, title: e.target.value})}
                         type="text"
                         placeholder="Post name"/>
                <MyInput
                    value={post.body}
                    onChange={e => setPost({...post, body: e.target.value})}
                    type="text"
                    placeholder="Post description"/>
                <MyButton onClick={addNewPost}>Create post</MyButton>
            </form>
            <PostList posts={posts} title="Posts about JS"/>

        </div>
    );
}

export default App;
