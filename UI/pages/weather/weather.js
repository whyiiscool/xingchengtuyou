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
    weather:{},
    part:{},
    note:{0:"多云",1:"阴",2:"晴"},
    city:{0:"岳麓区",1:"天心区",2:"雨花区"}
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    var myAmapFun = new amapFile.AMapWX({ key: '7e8f5a237ccf44e07a21f11c7d75eec0' });
    this.loadInfo();
    myAmapFun.getWeather({
      success: function (data) {
        that.setData({
          weather: data
        });
      },
      fail: function (info) {
        // wx.showModal({title:info.errMsg})
      }
    })
  },

  //获取当前位置的经纬度
  loadInfo: function () {
    var that = this;
    wx.getLocation({
      type: 'gcj02', //返回可以用于wx.openLocation的经纬度
      success: function (res) {
        var latitude = res.latitude//维度
        var longitude = res.longitude//经度
//        console.log(res);
        that.loadCity(latitude, longitude);
      }
    })
  },

  //把当前位置的经纬度传给高德地图，调用高德API获取当前地理位置，天气情况等信息
  loadCity: function (latitude, longitude) {
    var that = this;
    var myAmapFun = new amapFile.AMapWX({ key: markersData.key });
    myAmapFun.getRegeo({
      location: '' + longitude + ',' + latitude + '',//location的格式为'经度,纬度'
      success: function (data) {
        that.setData({
          part: data
        })
        console.log(data);
      },
      fail: function (info) { }
    });

    myAmapFun.getWeather({
      success: function (data) {
        that.setData({
          weather: data
        })
        console.log(data);
//        if (data.weather.data=="晴"){
//          note:"建议外出踏青"
//        }
        //成功回调
      },
      fail: function (info) {
        //失败回调
        console.log(info)
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

  }
})