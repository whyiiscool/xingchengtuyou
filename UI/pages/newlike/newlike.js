Page({
  //初始化数据
  data: {
    allValue: ''
  },
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },
  //表单提交按钮
  formSubmit: function (e) {
    console.log('form发生了submit事件，携带数据为：', e.detail.value)
    this.setData({
      allValue: e.detail.value
    })
    if (e.detail.value.input1.length == 0 ) {
      wx.showModal({
        title: '地点可不能为空哦',
        content: '请输入地点',
      })
    } else {
      wx.request({
        url: 'http://localhost:8080/WEB/newlike',
      //  url: 'https://www.doubleskinmilk.xyz:8443/WEB/newlike',

        data: {
          area: e.detail.value.input1,
          value: e.detail.value.input2,
        },

        header: {
          "Content-Type": "application/x-www-form-urlencoded;charset=utf-8"
        },

        //        header: {
        //          "Content-Type": "application/json;charset=GB2312"
        //        },
        method: "POST",
        success: function (res) {
          console.log(res.data)
          wx.showToast({
            title: '输入成功',//这里打印出登录成功
            icon: 'success',
            duration: 1000,
          })
        },
        fail: function (res) {
          console.log("失败");
        }
      })
    }
  },
  //表单重置按钮
  formReset: function (e) {
    console.log('form发生了reset事件，携带数据为：', e.detail.value)
    this.setData({
      allValue: ''
    })
  },


})