window.addEventListener('DOMContentLoaded', () => {
    const registerForm = window.document.getElementById('register-form');

    registerForm['addressPostFindButton'].addEventListener('click', () => {
        new daum.Postcode({
            oncomplete: (data) => {
                registerForm['addressPost'].value = data['zonecode'];
                registerForm['addressPrimary'].value = data['address'];
                registerForm['addressSecondary'].value = '';
                registerForm['addressSecondary'].focus();
            }
        }).open();
    });

    registerForm['email'].addEventListener('focusout', () => {
        const callback = (resp) => {
            const respJson = JSON.parse(resp);
            const emailWarning = registerForm.querySelector('[rel="email-warning"]');
            if (respJson['count'] === 0) {
                emailWarning.classList.remove('visible');
            } else {
                emailWarning.classList.add('visible');
            }
        };
        const formData = new FormData();
        formData.append('field', 'e');
        formData.append('value', registerForm['email'].value);
        Ajax.request('POST', '/apis/register/count', callback, ()=>{}, formData);
    });

    registerForm['disc-agree-all'].addEventListener('change', (e) => {
        registerForm['disc-agree-a'].checked = e.currentTarget.checked;
        registerForm['disc-agree-b'].checked = e.currentTarget.checked;
        registerForm['disc-agree-c'].checked = e.currentTarget.checked;
    });

    registerForm.onsubmit = () => {
        let inputs = registerForm.querySelectorAll('input');
        for (let i = 0; i < inputs.length; i++) {
            let input = inputs[i];
            if (input.dataset.regex !== undefined) {
                let regex = new RegExp(input.dataset.regex);
                let name = input.previousElementSibling.textContent;
                if (!regex.test(input.value)) {
                    alert(`올바른 ${name} 값을 입력해주세요.`);
                    console.log(name);
                    input.focus();
                    return false;
                }
            }
        }


        if (registerForm['password'].value !== registerForm['passwordCheck'].value) {
            alert('비밀번호가 서로 일치하지 않습니다.');
            registerForm['passwordCheck'].focus();
            return false;
        }

        if (registerForm['addressPost'].value === '') {
            alert('우편번호 버튼을 클릭해 우편번호를 선택해주세요.');
            registerForm['addressPostFindButton'].focus();
            return false;
        }

        if (!registerForm['disc-agree-a'].checked) {
            alert('이용약관을 읽고 동의해주세요.');
            return false;
        }

        if (!registerForm['disc-agree-b'].checked) {
            alert('개인정보 수집 및 이용을 읽고 동의해주세요.');
            return false;
        }
    };
});