// id가 modify-btn인 엘리먼트 조회
const modifyButton = document.getElementById('modify-btn');

if(modifyButton){
    modifyButton.addEventListener("click",event => {
        let params = new URLSearchParams(location.search);
        let id = params.get("id");

         fetch('/modify-article/'+id,{
            method:'PUT',
            headers:{
                "Content-Type":"application/json",
                "X-HTTP-Method-Override":"PUT"
            },
            body:JSON.stringify({
               "title":document.getElementById('title').value,
               "content":document.getElementById('content').value
            })
         })
         .then(()=>{
            alert('수정이 완료되었습니다.');
            location.replace('/articles/'+id);
         });
    });
}

const deleteButton = document.getElementById('delete-btn');
if(deleteButton){
    deleteButton.addEventListener('click',event => {
        let id = document.getElementId('article-id').value;

        fetch('/api/articles/'+id,{
            method:'DELETE'
            headers:{
                "X-HTTP-Method-Override":"DELETE"
            },
        })
        .then(()=>{
            alert('삭제가 완료되었습니다.');
            location.replace('/articles');
        })
    });
}