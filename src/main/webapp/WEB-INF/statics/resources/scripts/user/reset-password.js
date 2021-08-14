window.addEventListener('DOMContentLoaded', () => {
    const resetPasswordForm = window.document.getElementById('resetPasswordForm');
    resetPasswordForm.onsubmit = () => {
        let inputs = resetPasswordForm.querySelectorAll('input');
        for (let i = 0; i < inputs.length; i++) {
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

        if (resetPasswordForm['password'].value() !== resetPasswordForm['passwordCheck'].value()) {
            alert('비밀번호가 서로 일치하지 않습니다.');
            resetPasswordForm['passwordCheck'].focus();
            return false;
        }
    };
});