package com.neuroapis.classmate.api_end_points;
import com.neuroapis.classmate.Neura_crud_responses.GenericResponse;
import com.neuroapis.classmate.dataLayer.UserRepository;
import com.neuroapis.classmate.neura_classmate_services.UserService;
import com.neuroapis.classmate.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @2-NEURONS
 *
 * Handle Http Requests as well as converting Json Objects to required Pojo
 */
@RestController
public class UserController
{

    @Autowired
    UserService userService;
    @PostMapping("/neuro_api/1.0/users")
    public GenericResponse createUser(@RequestBody User user)
    {

        /**
         * handles requests for creating users
         */
          userService.save(user);
          return new GenericResponse("user saved");



    }

}
