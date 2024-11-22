
package com.example.demo.module.reply;

import com.example.demo.module.account.Account;
import com.example.demo.module.account.AccountMapper;
import com.example.demo.module.reply.form.ReplyCreateForm;
import com.example.demo.module.reply.form.ReplyResponseForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ReplyController {
    private final ReplyService replyService;
    private final AccountMapper accountMapper;

    @PostMapping("/api/member/reply")
    public ResponseEntity<?> createReply(@RequestBody ReplyCreateForm replyCreateForm,
                                         @AuthenticationPrincipal UserDetails userDetails){
        String username = userDetails.getUsername();
        Account account = accountMapper.getAccountByUsername(username);

        Reply reply = replyService.createReply(replyCreateForm, account.getId());
        return ResponseEntity.ok(reply);
    }

    @GetMapping("/api/common/reply/{id}")
    public ResponseEntity<?> getReply(@PathVariable("id") long noticeId){
        List<ReplyResponseForm> responseFormList = replyService.getReply(noticeId);
        return ResponseEntity.ok(responseFormList);
    }

}


