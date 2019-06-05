package com.jeegox.glio;

import com.jeegox.glio.util.Util;
import static com.google.common.truth.Truth.assertThat;
import com.jeegox.glio.constants.Environment;
import com.jeegox.glio.constants.StatusResponse;
import com.jeegox.glio.dto.UserResponse;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author j2esus
 */
public class JeegoxGlioTest {
    private Glio glio;
    
    @Before
    public void init() {
        glio = new Glio(Environment.PRODUCTION);
    }
    
    @Test
    public void login() throws Exception {
        UserResponse userResponse = glio.login("user", Util.encodeSha256("passsword"));
        assertThat(userResponse.getStatusResponse()).isEqualTo(StatusResponse.OK);
    }
}
