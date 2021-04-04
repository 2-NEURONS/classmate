package controllerTest;
import com.neuroapis.classmate.Neura_crud_responses.GenericResponse;
import com.neuroapis.classmate.NeuraclassmateApplication;
import com.neuroapis.classmate.api_end_points.UserController;
import com.neuroapis.classmate.dataLayer.UserRepository;
import com.neuroapis.classmate.user.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;   
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class) //
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = NeuraclassmateApplication.class) // start tomcat at a random port for testing pursoses
@ActiveProfiles("test")
public class UserControllerTest
{

    public static final String API_1_0_USERS = "/neuro_api/1.0/users";
    /**
     * Method naming scheme followed
     * methodName_condition_expectedBehaviour
     *
     * Test Posting a user to the server
     */

    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private UserRepository userRepository;

    @Before
    public void cleanUp()
    {
        userRepository.deleteAll();// let do some clean up
    }
    @Test
    public void postUser_whenUserIsValid_recieveOk()
    {
        ResponseEntity<Object> response = testRestTemplate.postForEntity(API_1_0_USERS, getUser(), Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    /**
     * Post and save usser to the database
     */
    @Test
    public void postUser_whenUserIsValid_userIsSavedToDatabase()
    {
       ResponseEntity<GenericResponse> response = testRestTemplate.postForEntity(API_1_0_USERS, getUser(), GenericResponse.class);
       assertThat(response.getBody().getRequestResponse()).isEqualTo("user saved");
       assertThat(userRepository.count()).isEqualTo(1);
    }
    /**
     * Factory methhod for supporting my tests
     * @return
     */
    private User getUser()
    {
        User user = new User();
        //set some properties
        user.setDisplayName("test-display");
        user.setPassword("P5ssword");
        user.setUserName("test-user");
        return user;
    }


}
