ClassicEditor
    .create(document.querySelector('#editor'))

    .then(editor => {
        theEditor = editor;
        console.log( editor );
    })

    .catch(error => {
        console.error( error );
    });

window.addEventListener('DOMContentLoaded', () => {
    const resetButton = window.document.getElementById("reset");

    resetButton.addEventListener('click', () => {
        theEditor.setData("");
    });

});

