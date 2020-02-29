//logs.js
const util = require('../../utils/util.js')

Page({
  data:{
    img:[
      "/pages/image/dufu.jpg",
      "/pages/image/aiwan.png",
      "/pages/image/xiangjiang.jpg",
      "/pages/image/juzi.jpg",
      "/pages/image/huogong.jpg"
    ],
    list: [{
      coverPath: '/pages/image/dufu.jpg',
      pageUrl: 'dufu/dufu'
    },
    {
      coverPath: '/pages/image/aiwan.png',
      pageUrl: 'aiwan/aiwan'
    },
    {
      coverPath: '/pages/image/xiangjiang.jpg',
      pageUrl: 'xiangjiang/xiangjiang'
    },
    {
      coverPath: '/pages/image/juzi.jpg',
      pageUrl: 'juzi/juzi'
    },
    {
      coverPath: '/pages/image/huogong.jpg',
      pageUrl: 'huogong/huogong'
    },
    
    ]
  },
  detail1: function (event) {
    wx.navigateTo({
      url: '/pages/travel/travel'
    })
  },
  detail2: function (event) {
    wx.navigateTo({
      url: '/pages/way/way'
    })
  },
  detail3: function (event) {
    wx.navigateTo({
      url: '/pages/recommend/recommend'
    })
  },
  jumpToInnerPage(e) {
    // console.log(e)
    wx.navigateTo({
      url: '/pages/' + e.currentTarget.dataset.pageid
    })
  }
})
