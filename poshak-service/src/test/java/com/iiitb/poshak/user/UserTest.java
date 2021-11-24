package com.iiitb.poshak.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserTest {

    @InjectMocks
    private User underTest;

    @Test
    public void user() {
        User user = new User();
        user.setId("22");
        user.setPassword("22");
        user.setEmailId("22");
        user.setCalorieGoal(22f);
        user.setCarbsGoal(22f);
        user.setHeight(22);
        user.setFatGoal(22f);
        user.setStatus(22);
        user.setName("22");
        user.setWeight(22);
        user.setProteinGoal(22f);
        Assertions.assertEquals("22", user.getPassword());
        Assertions.assertEquals("22", user.getEmailId());
        Assertions.assertEquals(22f, user.getCalorieGoal());
        Assertions.assertEquals("22", user.getId());
        Assertions.assertEquals(22, user.getStatus());
        Assertions.assertEquals("22", user.getName());
        Assertions.assertEquals(22, user.getWeight());
        Assertions.assertEquals(22f, user.getProteinGoal());
        Assertions.assertEquals(22f, user.getFatGoal());
        Assertions.assertEquals(22f, user.getCarbsGoal());
        Assertions.assertEquals(22, user.getHeight());
        String userString = "User(id=" + "22" + ", emailId=" + "22" +
                ", password=" + "22" + ", status=" + 22 + ", name=" +
                22 + ", height=" + 22 + ", weight=" + 22 +
                ", calorieGoal=" + 22 + ", fatGoal=" + 22 + ", carbsGoal=" +
                22 + ", proteinGoal=" + 22 + ")";

        Assertions.assertEquals(userString, userString);
        Assertions.assertEquals(hashCode(user), user.hashCode());
        Assertions.assertTrue(user.equals(user));
    }

    public int hashCode(User user) {
        int result = 1;
        result = result * 59 + user.getStatus();
        result = result * 59 + user.getHeight();
        result = result * 59 + user.getWeight();
        Object $calorieGoal = user.getCalorieGoal();
        result = result * 59 + ($calorieGoal == null ? 43 : $calorieGoal.hashCode());
        Object $fatGoal = user.getFatGoal();
        result = result * 59 + ($fatGoal == null ? 43 : $fatGoal.hashCode());
        Object $carbsGoal = user.getCarbsGoal();
        result = result * 59 + ($carbsGoal == null ? 43 : $carbsGoal.hashCode());
        Object $proteinGoal = user.getProteinGoal();
        result = result * 59 + ($proteinGoal == null ? 43 : $proteinGoal.hashCode());
        Object $id = user.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $emailId = user.getEmailId();
        result = result * 59 + ($emailId == null ? 43 : $emailId.hashCode());
        Object $password = user.getPassword();
        result = result * 59 + ($password == null ? 43 : $password.hashCode());
        Object $name = user.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        return result;
    }

    public boolean equals(final Object o, User user) {
        if (o == user) {
            return true;
        } else if (!(o instanceof User)) {
            return false;
        } else {
            User other = (User) o;
            if (!other.canEqual(user)) {
                return false;
            } else if (user.getStatus() != other.getStatus()) {
                return false;
            } else if (user.getHeight() != other.getHeight()) {
                return false;
            } else if (user.getWeight() != other.getWeight()) {
                return false;
            } else {
                Object user$calorieGoal = user.getCalorieGoal();
                Object other$calorieGoal = other.getCalorieGoal();
                if (user$calorieGoal == null) {
                    if (other$calorieGoal != null) {
                        return false;
                    }
                } else if (!user$calorieGoal.equals(other$calorieGoal)) {
                    return false;
                }

                label107:
                {
                    Object user$fatGoal = user.getFatGoal();
                    Object other$fatGoal = other.getFatGoal();
                    if (user$fatGoal == null) {
                        if (other$fatGoal == null) {
                            break label107;
                        }
                    } else if (user$fatGoal.equals(other$fatGoal)) {
                        break label107;
                    }

                    return false;
                }

                Object user$carbsGoal = user.getCarbsGoal();
                Object other$carbsGoal = other.getCarbsGoal();
                if (user$carbsGoal == null) {
                    if (other$carbsGoal != null) {
                        return false;
                    }
                } else if (!user$carbsGoal.equals(other$carbsGoal)) {
                    return false;
                }

                Object user$proteinGoal = user.getProteinGoal();
                Object other$proteinGoal = other.getProteinGoal();
                if (user$proteinGoal == null) {
                    if (other$proteinGoal != null) {
                        return false;
                    }
                } else if (!user$proteinGoal.equals(other$proteinGoal)) {
                    return false;
                }

                label86:
                {
                    Object user$id = user.getId();
                    Object other$id = other.getId();
                    if (user$id == null) {
                        if (other$id == null) {
                            break label86;
                        }
                    } else if (user$id.equals(other$id)) {
                        break label86;
                    }

                    return false;
                }

                label79:
                {
                    Object user$emailId = user.getEmailId();
                    Object other$emailId = other.getEmailId();
                    if (user$emailId == null) {
                        if (other$emailId == null) {
                            break label79;
                        }
                    } else if (user$emailId.equals(other$emailId)) {
                        break label79;
                    }

                    return false;
                }

                label72:
                {
                    Object user$password = user.getPassword();
                    Object other$password = other.getPassword();
                    if (user$password == null) {
                        if (other$password == null) {
                            break label72;
                        }
                    } else if (user$password.equals(other$password)) {
                        break label72;
                    }

                    return false;
                }

                Object user$name = user.getName();
                Object other$name = other.getName();
                if (user$name == null) {
                    if (other$name != null) {
                        return false;
                    }
                } else if (!user$name.equals(other$name)) {
                    return false;
                }

                return true;
            }
        }
    }

}