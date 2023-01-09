window.addEventListener('DOMContentLoaded', () => {
    const forgotEmailForm = window.document.getElementById('forgotEmailForm');
    forgotEmailForm.onsubmit = () => {
        let inputs = forgotEmailForm.querySelectorAll('input');
        for(let i = 0; i < inputs.length; i++) {
            let input = inputs[i];
            if (input.dataset.regex !== undefined) {
                let regex = new RegExp(input.dataset.regex);
                let name = input.previousElementSibling.textContent;
                if (!regex.test(input.value)) {
                    alert(`올바른 ${name} 값을 입력해주세요.`);
                    input.focus();
                    return false;
                }
            }
        }
    };
});