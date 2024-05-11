package com.ruoyi.web.controller.shift;

import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shift")
public class ShiftController {

    @GetMapping("/listShift")
    public AjaxResult listShift() throws Exception
    {
        List<ShiftUser> shiftUserList = new ArrayList<>();
        init(shiftUserList);
        shift(shiftUserList);
        return AjaxResult.success(shiftUserList);
    }

    @GetMapping("/doShift")
    public AjaxResult doShift() throws Exception
    {
        return AjaxResult.success();
    }

    private void init(List<ShiftUser> shiftUserList) {
        ShiftUser initUser = null;
        initUser = new ShiftUser("肖丹");
        shiftUserList.add(initUser);
        initUser = new ShiftUser("彭小林");
        shiftUserList.add(initUser);
        initUser = new ShiftUser("赵莉");
        shiftUserList.add(initUser);
        initUser = new ShiftUser("王凯彭");
        shiftUserList.add(initUser);
        initUser = new ShiftUser("马花");
        shiftUserList.add(initUser);
        initUser = new ShiftUser("汪宸燕");
        shiftUserList.add(initUser);
        initUser = new ShiftUser("陈宇杰");
        shiftUserList.add(initUser);
        initUser = new ShiftUser("樊海淘");
        shiftUserList.add(initUser);
        initUser = new ShiftUser("杜玉灵");
        shiftUserList.add(initUser);
        initUser = new ShiftUser("张义图");
        shiftUserList.add(initUser);
        initUser = new ShiftUser("曹小红");
        shiftUserList.add(initUser);
    }

    private void shift(List<ShiftUser> shiftUserList) {
        for (ShiftUser user : shiftUserList) {
            if ("肖丹".equals(user.getUserName())) {
                for (int i = 0; i < user.days.length; i++) {
                    if ((i+1)%7 == 4) {
                        user.days[i] = "OFF";
                    } else {
                        user.days[i] = "105";
                    }
                }
            }
            if ("马花".equals(user.getUserName())) {
                for (int i = 0; i < user.days.length; i++) {
                    if (i < 4) {
                        user.days[i] = "106";
                    } else if ((i+1)%7 == 5) {
                        user.days[i] = "OFF";
                    } else if (i >= 19 && i < 25) {
                        user.days[i] = "106";
                    } else {
                        user.days[i] = "105";
                    }
                }
            }
        }
    }

}

class ShiftUser {

    private String userName;
    public String days[] = new String[31];

    public ShiftUser() {
    }

    public ShiftUser(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
