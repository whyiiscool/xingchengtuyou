// pages/fruit/fruit.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      view: options.logsView
    })
    this.getdata(options.logsView);
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

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },

  getdata: function (view) {
    var that = this;
    wx.request({
      url: 'http://localhost:8080/WEB/fruit',
    //  url: 'https://www.doubleskinmilk.xyz:8443/WEB/fruit',

      data: {
        message:view
      },

      header: {
        "Content-Type": "application/json"
      //  "Content-Type": "application/x-www-form-urlencoded"
      },
      method: "GET",
      success: function (res) {
        console.log(res.data)
        //var list=res.data;
        //if (typeof list != 'object'){
        //  list = list.replace(/\ufeff/g, "");
        //  var message = JSON.parse(list);
        //  res.data = message;
        //}

        that.setData({
          list: res.data
        })

        wx.showToast({
          title: '获取成功',//这里打印出登录成功
          icon: 'success',
          duration: 1000,
        })
      },
      fail: function (res) {
        console.log("失败");
      }
    })
  }
})