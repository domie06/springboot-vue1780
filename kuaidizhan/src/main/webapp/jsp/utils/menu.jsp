<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
var menus = [
	{
        "backMenu":[
			{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除",
                        ],
                        "menu":"用户管理",
                        "menuJump":"列表",
                        "tableName":"yonghu"
                    }
                ],
                "menu":"用户管理"
            }
			
			,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除",
                        ],
                        "menu":"代取人管理",
                        "menuJump":"列表",
                        "tableName":"daiquren"
                    }
                ],
                "menu":"代取人管理"
            },
			{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除",
                        ],
                        "menu":"快递站点管理",
                        "menuJump":"列表",
                        "tableName":"zhandian"
                    }
                ],
                "menu":"快递站点管理"
            },
			{
                "child":[
                    {
                        "buttons":[
                            "新增",
                            "修改",
                            "删除",
                        ],
                        "menu":"待取件表管理",
                        "menuJump":"列表",
                        "tableName":"daiqu"
                    }
                ],
                "menu":"待取件表管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "新增",
                            "删除",
                        ],
                        "menu":"快递接单表管理",
                        "menuJump":"列表",
                        "tableName":"jiedan"
                    }
                ],
                "menu":"快递接单表管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "删除",
                        ],
                        "menu":"已接单表管理",
                        "menuJump":"列表",
                        "tableName":"yijiedan"
                    }
                ],
                "menu":"已接单表管理"
            }          
        ],
        "frontMenu":[

        ],
        "roleName":"管理员",
        "tableName":"users"
    },
	{
        "backMenu":[
			{
                "child":[
                    {
                        "buttons":[
						  "查看",
                        ],
                        "menu":"快递站点管理",
                        "menuJump":"列表",
                        "tableName":"zhandian"
                    }
                ],
                "menu":"快递站点管理"
            },
			{
                "child":[
                    {
                        "buttons":[
                            "接单",
                        ],
                        "menu":"快递接单表管理",
                        "menuJump":"列表",
                        "tableName":"jiedan"
                    }
                ],
                "menu":"快递接单表管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
						    "查看",
                        ],
                        "menu":"已接单表管理",
                        "menuJump":"列表",
                        "tableName":"yijiedan"
                    }
                ],
                "menu":"已接单表管理"
            }          
        ],
        "frontMenu":[

        ],
        "roleName":"代取人",
        "tableName":"daiquren"
    },
	{
        "backMenu":[
			{
                "child":[
                    {
                        "buttons":[
                            "查看",
                   
                        ],
                        "menu":"快递站点管理",
                        "menuJump":"列表",
                        "tableName":"zhandian"
                    }
                ],
                "menu":"快递站点管理"
            },
			{
                "child":[
                    {
                        "buttons":[
                            "取件",
                            "发布订单",
                        ],
                        "menu":"待取件表管理",
                        "menuJump":"列表",
                        "tableName":"daiqu"
                    }
                ],
                "menu":"待取件表管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "寄件",
                        ],
                        "menu":"快递接单表管理",
                        "menuJump":"列表",
                        "tableName":"jiedan"
                    }
                ],
                "menu":"快递接单表管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "完成",
                        ],
                        "menu":"已接单表管理",
                        "menuJump":"列表",
                        "tableName":"yijiedan"
                    }
                ],
                "menu":"已接单表管理"
            }          
        ],
        "frontMenu":[

        ],
        "roleName":"用户",
        "tableName":"yonghu"
    }
];

var hasMessage = '';
