/**
 * 2017-10-6 11:49:59
 * 会员注册页面的js文件
 */

var app = new Vue({
    el: '#app',
    data: {
        url: routerUrl,
        tipsData: [],
        formValidate: {
            account: '',
            password: '',
            passwordCheck: '',
            tel: '',
            mail: ''
        },
        ruleValidate: {
            account: [
                {required: true, message: '账号不能为空', trigger: 'blur'},
                {type: 'string', min: 6, message: '账号长度不能小于6位', trigger: 'blur'}
            ],
            password: [
                {required: true, message: '密码不能为空', trigger: 'blur'},
                {type: 'string', min: 6, message: '密码长度不能小于6位', trigger: 'blur'}
            ],
            passwordCheck: [
                {required: true, message: '请输入验证密码', trigger: 'blur'},
                {type: 'string', min: 6, message: '密码长度不能小于6位', trigger: 'blur'}
            ],
            tel: [
                {required: true, message: '手机号码不能为空', trigger: 'blur'},
                {min: 11, max: 11, message: '手机号码长度错误', trigger: 'blur'}
            ],
            mail: [
                {required: true, message: '邮箱不能为空', trigger: 'blur'},
                {type: 'email', message: '邮箱格式不正确', trigger: 'blur'}
            ]
        }
    },
    methods: {
        handleSubmit: function (name) {
            this.$refs[name].validate(function (valid) {
                if (valid) {
                    /*判断两次密码是否相同*/
                    if (app.formValidate.password != app.formValidate.passwordCheck) {
                        app.$Modal.error({
                            title: '密码错误',
                            content: '请输入两次相同的密码!'
                        });
                        return;
                    } else {
                        /*校验通过则提交表单*/
                        Ajx.post(routerUrl.post.userVipReg, {
                            account: app.formValidate.account,
                            password: app.formValidate.password,
                            telephone: app.formValidate.tel,
                            email: app.formValidate.mail,
                        }).then(function (response) {
                            if (response.data == true) {
                                /*注册成功后的提示框*/
                                app.$Modal.success({
                                    title: '注册成功',
                                    content: '验证邮件已经发送,请尽快前往验证!',
                                    onOk: function () {
                                        window.location.href = "login.html"
                                    }
                                })
                                ;
                            }
                        }).catch(function (error) {
                            app.$Modal.error({
                                title: '注册失败',
                                content: error.response.data.message
                            });
                        });

                    }
                } else {
                    app.$Modal.error({
                        title: '注册失败',
                        content: '请仔细检查信息是否输入有误'
                    });
                }
            })
        },
        handleSearch: function (value) {
            /*邮箱输入的自动补全*/
            this.tipsData = !value || value.indexOf('@') >= 0 ? [] : [
                value + '@qq.com',
                value + '@sina.com',
                value + '@163.com'
            ];
        }
    }
});