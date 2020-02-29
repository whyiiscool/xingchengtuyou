// pages/way/way.js
let app=getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    date: '2019-05-01',


  },

  /**
   * 生命周期函数--监听页面加载
   */
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
 //   submitForm;
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

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
   
  },


  submitForm:function(e){
    if (e.detail.value.from.length == 0 || e.detail.value.to.length == 0){
      wx.showModal({
        title: '出发点或目的地不能为空!',
        content: '请输入地点',
      })
    }else {
      wx.request({
        url: 'http://localhost:8080/WEB/wx',
      //  url: 'https://www.doubleskinmilk.xyz:8443/WEB/tt',

        data:{
          from: e.detail.value.from,
          to: e.detail.value.to,
          car: e.detail.value.car,
          hotel: e.detail.value.hotel,
          ps: e.detail.value.ps,
          time:e.detail.value.time
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
  bindDateChange: function (e) {
    this.setData({
      date: e.detail.value
    })
  },
})