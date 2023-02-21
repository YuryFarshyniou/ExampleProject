import React, {useState} from 'react';
import './styles/App.css'
import PostList from "./Components/PostList";
import PostForm from "./Components/PostForm";
import {MySelect} from "./Components/UI/select/MySelect";

function App() {
    const [posts, setPosts] = useState([
        {id: 55, title: "JavaScript", body: "JAvascript has a dick"},
        {id: 76, title: "Java", body: "Cool language"},
        {id: 999, title: "Python", body: "Fucking snake"}
    ])

    const createPost = (newPost) => {
        setPosts([...posts, newPost])
    }
    const removePost = (post) => {
        setPosts(posts.filter(p => p.id !== post.id))
    }
    const [selectedSort, setSelectedSort] = useState('')

    const sortPosts = (sort) => {
        setSelectedSort(sort);
        setPosts([...posts].sort((a, b) => a[sort].localeCompare(b[sort])))
    }

    return (
        <div className="App">
            <PostForm create={createPost}/>
            <hr style={{margin: '15px 0'}}/>
            <MySelect defaultValue={"Sorting"}
                      value={selectedSort}
                      onChange={sortPosts}
                      options={[{value: 'title', name: "Name"},
                          {value: 'body', name: "Description"}

                      ]}
            />
            {posts.length
                ? <PostList remove={removePost} posts={posts} title="Posts about JS"/>
                : <h1 style={{textAlign: 'center'}}>Post list is empty!</h1>}


        </div>
    );
}

export default App;
