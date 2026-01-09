package kr.java.pr1mary.controller.view;

import kr.java.pr1mary.dto.view.TeacherDTO;
import kr.java.pr1mary.entity.user.TeacherProfile;
import kr.java.pr1mary.service.TeacherProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profile/teacher")
@RequiredArgsConstructor
public class TeacherProfileController {
    private final TeacherProfileService profileService;

    // 프로필 페이지
    @GetMapping
    public String teacherProfilePage(@RequestParam("id") Long id, Model model) {
        model.addAttribute("profile", profileService.getProfileByTeacherId(id));
        return "pages/profiles/teacher-profile";
    }

    // 프로필 공개 페이지
    @GetMapping("/public")
    public String teacherPublicProfilePage(@RequestParam("id") Long id, Model model) {
        model.addAttribute("profile", profileService.getProfileByTeacherId(id));
        return "pages/profiles/teacher-profile-public";
    }

    // 프로필 편집 페이지
    @GetMapping("/update")
    public String updateTeacherProfilePage(@RequestParam("id") Long id, Model model) {
        model.addAttribute("profile", profileService.getProfileByTeacherId(id));
        return "pages/profiles/teacher-profile-update";
    }

    // 프로필 이미지 수정
    @PostMapping("/update/image")
    public String updateTeacherProfileImage(@RequestBody TeacherDTO dto) {
        profileService.setTeacherImage(dto);
        return "redirect:/profile/teacher/update";
    }

    // 프로필 한줄 소개 수정
    @PostMapping("/update/introduce")
    public String updateTeacherProfileIntroduce(@RequestBody TeacherDTO dto) {
        profileService.setTeacherIntroduce(dto);
        return "redirect:/profile/teacher/update";
    }

    // 프로필 담당 과목 수정
    @PostMapping("/update/subject")
    public String updateTeacherProfileSubject(@RequestBody TeacherDTO dto) {
        profileService.saveSubject(dto);
        return "redirect:/profile/teacher/update";
    }
}
