
import { test, expect } from "@playwright/test";

test("Student portal should open successfully", async ({ page }) => {
  await page.goto("/");

  await expect(page).toHaveTitle(/playright-demo/);

  await expect(
    page.getByRole("heading", {
      name: "Student Portal",
    })
  ).toBeVisible();
});

test("Admin should login successfully", async ({ page }) => {
  await page.goto("/");

  await page.getByLabel("Email").fill("admin@test.com");
  await page.getByLabel("Password").fill("123456");

  await page.getByRole("button", {
    name: "Login",
  }).click();

  await expect(
    page.getByRole("heading", {
      name: "Student Dashboard",
    })
  ).toBeVisible();

  await expect(page.getByText("Welcome Admin")).toBeVisible();
});

test("Invalid login should display error", async ({ page }) => {
  await page.goto("/");

  await page.getByLabel("Email").fill("wrong@test.com");
  await page.getByLabel("Password").fill("wrong123");

  await page.getByRole("button", {
    name: "Login",
  }).click();

  await expect(page.getByRole("alert"))
    .toHaveText("Invalid email or password");
});

test("Capture student portal screenshot", async ({ page }) => {
  await page.goto("/");

  await page.screenshot({
    path: "screenshots/student-portal.png",
    fullPage: false,
  });
});
