//获取应用实例
const app = getApp()
Page({
  data: {
    list: [{
        price: '中国四大名亭之一',
        name: '爱晚亭',
        coverPath: '../image/aiwan.png',
        pageUrl: 'aiwan/aiwan'
      },
      {
        price: '湖湘味道',
        name: '火宫殿',
        coverPath: '../image/huogong.jpg',
        pageUrl: 'huogong/huogong'
      },
      {
        price: '5A级旅游景区',
        name: '橘子洲',
        coverPath: '../image/juzi.jpg',
        pageUrl: 'juzi/juzi'
      },
      {
        price: '风撑三连跨',
        name: '湘江大桥',
        coverPath: '../image/xiangjiang.jpg',
        pageUrl: 'xiangjiang/xiangjiang'
      },
      {
        price: '观橘洲风景、远眺麓山烟',
        name: '杜甫江阁',
        coverPath: '../image/dufu.jpg',
        pageUrl: 'dufu/dufu'
      },
      {
        price: '夜长沙',
        name: '解放西',
        coverPath: '../image/jiefang.jpg',
        pageUrl: 'jiefang/jiefang'
      },
      {
        price: '国际文化艺术中心',
        name: '梅溪湖',
        coverPath: '../image/meixi.jpg',
        pageUrl: 'meixi/meixi'
      },
      {
        price: '主题乐园的领跑者',
        name: '世界之窗',
        coverPath: '../image/shijie.jpg',
        pageUrl: 'shijie/shijie'
      },
      {
        price: '湖南母亲河',
        name: '浏阳河',
        coverPath: '../image/liuyang.jpg',
        pageUrl: 'liuyang/liuyang'
      },
      {
        price: '烈士公园',
        name: '烈士公园',
        coverPath: '../image/lieshi.jpg',
        pageUrl: 'liesi/liesi'
      },
      {
        price: '购物天堂',
        name: '五一广场',
        coverPath: '../image/wuyi.jpg',
        pageUrl: 'wuyi/wuyi'
      },
      {
        price: '湖南名校',
        name: '国防科大',
        coverPath: '../image/keda.jpg',
        pageUrl: 'guofang/guofang'
      },
      {
        price: '湖南名校',
        name: '湖南中医药大学',
        coverPath: '../image/zyy.jpg',
        pageUrl: 'zzy/zzy'
      }, 
      {
        price: '湖南名校',
        name: '湖南大学',
        coverPath: '../image/hn.jpg',
        pageUrl: 'hn/hn'
      },

    ]
  },

  jumpToInnerPage(e) {
    // console.log(e)
    wx.navigateTo({
      url: '/pages/' + e.currentTarget.dataset.pageid
    })
  }
})