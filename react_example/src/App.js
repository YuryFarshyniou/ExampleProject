import React, {useMemo, useState} from 'react';
import './styles/App.css'
import PostList from "./Components/PostList";
import PostForm from "./Components/PostForm";
import {MySelect} from "./Components/UI/select/MySelect";
import MyInput from "./Components/UI/input/MyInput";

export function App() {
    const [posts, setPosts] = useState([
        {id: 55, title: "JavaScript", body: "JAvascript has a dick"},
        {id: 76, title: "Java", body: "Cool language"},
        {id: 999, title: "Python", body: "Fucking snake"}
    ])
    const [searchQuery, setSearchQuery] = useState('');

    const createPost = (newPost) => {
        setPosts([...posts, newPost])
    }
    const removePost = (post) => {
        setPosts(posts.filter(p => p.id !== post.id))
    }
    const [selectedSort, setSelectedSort] = useState('');

    const sortedPost = useMemo(()=>{
        console.log("Sorted function called!")
        if(selectedSort){
            return [...posts].sort((a, b) => a[selectedSort].localeCompare(b[selectedSort]));
        }
        return posts;
    },[selectedSort,posts]) ;
  const sortedAndSearchedPosts = useMemo(()=>{

  },[])

    const sortPosts = (sort) => {
        setSelectedSort(sort);
    }

    return (
        <div className="App">
            <PostForm create={createPost}/>
            <hr style={{margin: '15px 0'}}/>
            <div>
                <MyInput
                    placeholder="Searching..."
                    value={searchQuery}
                    onChange={e => setSearchQuery(e.target.value)}

                />
                <MySelect defaultValue={"Sorting"}
                          value={selectedSort}
                          onChange={sortPosts}
                          options={[{value: 'title', name: "Name"},
                              {value: 'body', name: "Description"}

                          ]}
                />
            </div>

            {posts.length
                ? <PostList remove={removePost} posts={sortedPost} title="Posts about JS"/>
                : <h1 style={{textAlign: 'center'}}>Post list is empty!</h1>}
        </div>
    );
}