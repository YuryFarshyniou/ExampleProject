import {useState} from "react";

export const useInitializePosts =()=>{
    return useState([
        {id: 55, title: "JavaScript", body: "JAvascript has a dick"},
        {id: 76, title: "Java", body: "Cool language"},
        {id: 999, title: "Python", body: "Fucking snake"}
    ])
}