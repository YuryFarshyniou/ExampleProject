import React from 'react';
import MyButton from "../Components/UI/button/MyButton";
import MyModal from "../Components/UI/MyModal/MyModal";
import PostForm from "../Components/PostForm";
import PostFilter from "../Components/PostFilter";
import Loader from "../Components/UI/loader/Loader";
import PostList from "../Components/PostList";
import Pagination from "../Components/UI/pagination/Pagination";
import {useEffect, useState} from "react";
import {useFetching} from "../hooks/useFetching";
import PostService from "../API/PostService";
import {getPageCount} from "../utils/pages";
import {usePosts} from "../hooks/usePosts";

const Posts = () => {
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

    const [fetchPosts, isPostsLoading, postError] = useFetching(async (limit, page) => {
        const postsFromServer = (await PostService.getAll(limit, page));
        setPosts(postsFromServer.data);
        const totalCount = postsFromServer.headers['x-total-count'];
        setTotalPages(getPageCount(totalCount, limit));
    })


    const changePage = (page) => {
        setPage(page);
        fetchPosts(limit, page);

    };

    useEffect(() => {
        fetchPosts(limit, page);
    }, []);

    const removePost = (post) => {
        setPosts(posts.filter(p => p.id !== post.id))
    };

    const sortedAndSearchedPosts = usePosts(posts, filter.sort, filter.query);
    return (
        <div>
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
            <Pagination totalPages={totalPages} page={page} changePage={changePage}/>
        </div>
    );
};

export default Posts;