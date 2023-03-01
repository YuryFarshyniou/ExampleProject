import React, {useEffect, useState} from 'react';
import './styles/App.css'
import PostList from "./Components/PostList";
import PostForm from "./Components/PostForm";
import PostFilter from "./Components/PostFilter";
import MyModal from "./Components/UI/MyModal/MyModal";
import MyButton from "./Components/UI/button/MyButton";
import {usePosts} from "./hooks/usePosts";
import PostService from "./API/PostService";
import Loader from "./Components/UI/loader/Loader";
import {useFetching} from "./hooks/useFetching";
import {getPageCount, getPagesArray} from "./utils/pages";

export function App() {
    const [posts, setPosts] = useState([]);
    const [filter, setFilter] = useState({sort: '', query: ''});
    const [modal, setModal] = useState(false);
    const [totalPages, setTotalPages] = useState(0);
    const [limit, setLimit] = useState(10);
    const [page, setPage] = useState(1);
    const createPost = (newPost) => {
        setPosts([...posts, newPost])
        setModal(false);
    }

    const [fetchPosts, isPostsLoading, postError] = useFetching(async () => {
        const postsFromServer = (await PostService.getAll(limit, page));
        setPosts(postsFromServer.data);
        const totalCount = postsFromServer.headers['x-total-count'];
        setTotalPages(getPageCount(totalCount, limit));
    })

    let pagesArray = getPagesArray(totalPages);

    useEffect(() => {
        fetchPosts()
    }, [])

    const removePost = (post) => {
        setPosts(posts.filter(p => p.id !== post.id))
    }

    const sortedAndSearchedPosts = usePosts(posts, filter.sort, filter.query);

    return (
        <div className="App">
            <button onClick={fetchPosts}>asd</button>
            <MyButton style={{marginTop: 30}} onClick={() => setModal(true)}>
                Create post
            </MyButton>
            <MyModal visible={modal} setVisible={setModal}>
                <PostForm create={createPost}/>

            </MyModal>
            <hr style={{margin: '15px 0'}}/>
            <PostFilter filter={filter}
                        setFilter={setFilter}/>
            {postError &&
                <h1> Error! ${postError}</h1>}
            {isPostsLoading
                ? <div style={{display: 'flex', justifyContent: 'center', marginTop: 50}}>
                    <Loader/>
                </div>
                : <PostList remove={removePost} posts={sortedAndSearchedPosts} title="Posts about JS"/>
            }
            <div className='page__wrapper'>
                {pagesArray.map(p =>
                    <span
                        onClick={() => setPage(p)}
                        key={p}
                        className={page === p ? 'page page__current' : 'page'}
                    >
                        {p}
                    </span>
                )}
            </div>

        </div>
    );
}