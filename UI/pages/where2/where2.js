// pages/where2/where2.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    msgData: [] 
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var wayShow = options.way
    let that = this
    that.setData({
      wayShow: options.way
    })
    wx.request({
      url: 'http://localhost:8080/WEB/route1',

      data: {
        wayShow
      },

      header: {
        "Content-Type": "application/json"
        //  "Content-Type": "application/x-www-form-urlencoded"
      },
      method: "GET",
      success: function (res) {
        console.log(res.data)

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

    changeInputValue(ev){
    this.setData({
      inputVal: ev.detail.value
    })
  },
  //删除留言
  DelMsg(ev){
    var n = ev.target.dataset.index;

    var list = this.data.msgData;
    list.splice(n, 1);

    this.setData({
      msgData: list
    });
  },
  //添加留言
  addMsg(){
    var list = this.data.msgData;
    list.push({
      msg: this.data.inputVal
    });
    //更新
    this.setData({
      msgData: list,
      inputVal: ''
    });
  },


})