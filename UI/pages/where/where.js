var amapFile = require('../../utils/amap-wx.js');
var markersData = {
  latitude: '',//纬度
  longitude: '',//经度
  key: "7e8f5a237ccf44e07a21f11c7d75eec0"//申请的高德地图key
};
Page({

  /**
   * 页面的初始数据
   */
  data: {
    weather: {},
    day: [
      { name: '无', value: '无', checked: 'true' },
      { name: '1', value: '1天' },
      { name: '2', value: '2天' },
      { name: '3', value: '3天' },
      { name: '4', value: '4天' },
      ],
    type: [
      { name: '无', value: '无', checked: 'true' },
      { name: '观光', value: '观光' },
      { name: '美食', value: '美食' },
      { name: '购物', value: '购物' },
      { name: '玩乐', value: '玩乐' },
      ]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  radioChange: function (e) {
    console.log('radio发生change事件，携带value值为：', e.detail.value)
  },

  onLoad: function (options) {
    var that = this;
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

  submitForm: function (e) {
    var that = this;
  //  console.log(e.detail.value);
    wx.request({
      url: 'http://localhost:8080/WEB/route',

      data: {
        day: e.detail.value.day,
        type: e.detail.value.type
      },
      
      header: {
        "Content-Type": "application/x-www-form-urlencoded;charset=utf-8"
      },

      success: function (res) {
        that.setData({
          search: res.data
        })
      //  console.log(res.data)
        if(res.data==''){
          wx.showToast({
            title: '无满足要求的路线',
            icon:'none',
            duration:2000
          })
        }else{
          let str = JSON.stringify(res.data);
        //  console.log(str);
          wx.navigateTo({
            url: '../where1/where1?data=' + str
          })
        }
      }
    })
  }
})