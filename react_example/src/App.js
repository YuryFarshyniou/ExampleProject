import React, {useMemo, useState} from 'react';
import './styles/App.css'
import PostList from "./Components/PostList";
import PostForm from "./Components/PostForm";
import PostFilter from "./Components/PostFilter";

export function App() {
    const [posts, setPosts] = useState([
        {id: 55, title: "JavaScript", body: "JAvascript has a dick"},
        {id: 76, title: "Java", body: "Cool language"},
        {id: 999, title: "Python", body: "Fucking snake"}
    ])
    const [filter, setFilter] = useState({sort: '', query: ''})

    const createPost = (newPost) => {
        setPosts([...posts, newPost])
    }
    const removePost = (post) => {
        setPosts(posts.filter(p => p.id !== post.id))
    }

    const sortedPosts = useMemo(() => {
        if (filter.sort) {
            return [...posts].sort((a, b) => a[filter.sort].localeCompare(b[filter.sort]));
        }
        return posts;
    }, [filter.sort, posts]);

    const sortedAndSearchedPosts = useMemo(() => {
        return sortedPosts.filter(post => post.title.toLocaleLowerCase().includes(filter.query))
    }, [filter.query, sortedPosts])

    return (
        <div className="App">
            <PostForm create={createPost}/>
            <hr style={{margin: '15px 0'}}/>
            <PostFilter filter={filter}
                        setFilter={setFilter}/>
            {sortedAndSearchedPosts.length
                ? <PostList remove={removePost} posts={sortedAndSearchedPosts} title="Posts about JS"/>
                : <h1 style={{textAlign: 'center'}}>Post list is empty!</h1>}
        </div>
    );
}